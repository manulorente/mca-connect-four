package mcloudapps.connectFour;

import mcloudapps.utils.Console;

public enum Color {
    R, Y, NONE;

    static Color get(int ordinal){
		assert ordinal >= 0 && ordinal < Color.NONE.ordinal();

		return Color.values()[ordinal];
	}

    public void write() {
		String string = this.name();
		if (this.isNull()) {
			string = " ";
		}
		Console.getInstance().write(string);        
    }

	boolean isNull() {
		return this == Color.NONE;
	}

    public String toString() {
        return this.name();
    }

}
