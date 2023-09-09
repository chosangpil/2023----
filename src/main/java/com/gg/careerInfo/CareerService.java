package com.gg.careerInfo;

import java.util.List;

public interface CareerService {
	public abstract void insertCareer(CareerDTO dto);
	public abstract List<CareerDTO> careerList(String userID);
}
