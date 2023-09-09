package com.gg.indvUser;

public interface IndvService {
	public abstract void insertIndv(IndvDTO dto);
	public abstract IndvDTO getIndv(String userID);
}