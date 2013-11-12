package minesweeper.core.support;


public class XYLocation {
  
    private int X;
    private int Y;
    
    public void setX(int X) {
        this.X = X;
    }
    public void setX(Integer X) {
        this.X = X;
    }
    public void setY(int Y) {
        this.Y = Y;
    }
    public void setY(Integer Y) {
        this.Y = Y;
    }
    public XYLocation(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }
    public XYLocation(){
        X = 0;
        Y = 0;
    }
    
    public XYLocation left(){
        return new XYLocation(X-1,Y);
    }
    public XYLocation right(){
        return new XYLocation(X+1,Y);
    }
    public XYLocation up(){
        return new XYLocation(X,Y-1);
    }
    public XYLocation down(){
        return new XYLocation(X,Y+1);    
    }
    public XYLocation[] getNeighbours(){
        return new XYLocation[]{
            up().left(),up(),up().right(),
            left(),right(),
            down().left(),down(),down().right()};
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
    
    @Override
    public String toString(){
        String string = "";
        string += "x= "+X + " y= " + Y ;
        return string;
    }
    
    @Override
    public boolean equals(Object o) {
	if (null == o || !(o instanceof XYLocation)) {
		return super.equals(o);
	}
	XYLocation anotherLoc = (XYLocation) o;
	return ((anotherLoc.getX() == X) && (anotherLoc.getY() == Y));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.X;
        hash = 29 * hash + this.Y;
        return hash;
    }

}
