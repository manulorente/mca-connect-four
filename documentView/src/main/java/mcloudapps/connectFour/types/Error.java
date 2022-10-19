package mcloudapps.connectFour.types;

public enum Error {
	FULL_BOARD,
	INVALID_COLUMN,
	FULL_COLUMN,
	OUT_OF_TOKENS,
	NULL;

	public boolean isNull() {
		return this == Error.NULL;
	}
}