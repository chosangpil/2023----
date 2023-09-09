package com.gg.compUser;

public interface CompService {
	public abstract void insertComp(CompDTO dto);
	public abstract CompDTO getComp(String userID);
}
