package mcloudapps.utils;

public class Coordinate {

    protected int row;
	protected int column;

	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

    public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (!other.isNull()) {
            if (this.getRow() != other.getRow())
                return false;
          return this.getColumn() == other.getColumn();
        }
        return true;
    }

	public boolean isNull() {
		return false;
	}
}
