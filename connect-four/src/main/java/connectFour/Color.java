package connect-four;

enum Color {
    Rojo,
	Amarillo,
	NULL;

	static Color get(int ordinal){
		assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

		return Color.values()[ordinal];
	}

	void write() {
		String string = this.name();
		if (this.isNull()) {
			string = " ";
		}
	
    
}
