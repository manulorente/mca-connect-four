package mcloudapps.connectFour;

import mcloudapps.utils.Direction;

public class Cell {

    int row, column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void shift(Direction direction) {
        this.row += direction.directionRow;
        this.column += direction.directionColumn;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) this.row;
        result = prime * result + (int) this.column;
        return result;       
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Cell other = (Cell) obj;
        return this.row == other.row && this.column == other.column;
    }

    @Override
    public Object clone(){
        return new Cell(this.row, this.column);
    }
}
