package cosc322;


class move
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