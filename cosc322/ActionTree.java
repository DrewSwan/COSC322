/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc322;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author drews
 */
public class ActionTree {
    
    private Node<BoardGameModel> root;
    static boolean white = true;
    ArrayList<ArrayList<Node<BoardGameModel>>> depthNodes = new ArrayList<ArrayList<Node<BoardGameModel>>>(10);
    
    
    public ActionTree(BoardGameModel rootData) {
        root = new Node<BoardGameModel>();
        root.data = rootData;
        root.children = new ArrayList<Node<BoardGameModel>>();
        root.depth = 0;
        ArrayList<Node<BoardGameModel>> temp = new ArrayList<Node<BoardGameModel>>();
        temp.add(root);
        depthNodes.add(temp);
    }
    
    public BoardGameModel minMax(){
        return minMax(root);
    }
    
    public BoardGameModel minMax(Node<BoardGameModel> currentNode){
        int bestMoveStrength = minMaxEvaluation(currentNode);
        System.out.println(bestMoveStrength);
        for(Node<BoardGameModel> currentChild : currentNode.children){
            System.out.println(currentChild.strength);
            if(currentChild.strength == bestMoveStrength){
                return currentChild.data;
            }
        }
        return null;
    }
    
    //IMPORTANT NOTE: THE WHITE STATIC VARIABLE NEEDS TO BE MODIFIED AFTER INTEGRATION!!!
    public int minMaxEvaluation(Node<BoardGameModel> currentNode){
        
        int currentValue;
        int currentChildValue;
        
        if(currentNode.children.isEmpty()){
          return -1001;
        }else{
            //Is our turn (max)
            if(currentNode.data.getWhiteTurn() == white){
                currentValue = -1000;
                for(Node<BoardGameModel> currentChild : currentNode.children){
                    currentChildValue = minMaxEvaluation(currentChild);
                    if(currentChildValue == -1001){
                        currentNode.data.evaluate();
                        return currentNode.data.getEvaluation();
                    }
                    if(currentChildValue > currentValue){
                        currentValue = currentChildValue;
                    }
                }
            //Is not our turn (min)
            }else{
                currentValue = 1000;
                for(Node<BoardGameModel> currentChild : currentNode.children){
                    currentChildValue = minMaxEvaluation(currentChild);
                    if(currentChildValue == -1001){
                        currentNode.data.evaluate();
                        return currentNode.data.getEvaluation();
                    }
                    if(currentChildValue < currentValue){
                        currentValue = currentChildValue;
                    }
                }
            }
            currentNode.strength = currentValue;
            return currentValue;
        }
    }
    
    public Node<BoardGameModel> getRoot(){
        return root;
    }
    
    public static class Node<BoardGameModel> {
        private BoardGameModel data;
        private Node<BoardGameModel> parent;
        private List<Node<BoardGameModel>> children;
        private Node<BoardGameModel> favouriteChild;
        private int strength;
        private int depth;
       
        
        public Node<BoardGameModel> createChild(BoardGameModel childData){
            Node<BoardGameModel> childNode = new Node<BoardGameModel>();
            childNode.data = childData;
            childNode.children = new ArrayList<Node<BoardGameModel>>();
            childNode.parent = this;
            childNode.depth = this.getDepth() + 1;
            this.children.add(childNode);
            
            return childNode;
        }
        
        public BoardGameModel getData(){
            return data;
        }
        
        public int getDepth(){
            return depth;
        }
    }
}