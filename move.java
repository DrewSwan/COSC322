/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc322;


public class move
{
  int qx;
  int qy;
  int nx;
  int ny;
  int ax;
  int ay;
  
  public move(int qx, int qy, int nx, int ny, int ax, int ay)
  {
    this.qx = qx;
    this.qy = qy;
    this.nx = nx;
    this.ny = ny;
    this.ax = ax;
    this.ay = ay;
  }
  
  public move(int qx, int qy, int x, int y) { this.qx = qx;
    this.qy = qy;
    nx = x;
    ny = y;
    ax = -1;
    ay = -1;
  }
}
