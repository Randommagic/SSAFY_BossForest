package com.ssafy.raid.ranking.dto;

import java.io.Serializable;

public class RankingUnitId implements Serializable {
    
    private static final long serialVersionUID = 1L;
 
    private int uid;

    private int rankingId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rankingId;
		result = prime * result + uid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RankingUnitId other = (RankingUnitId) obj;
		if (rankingId != other.rankingId)
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
	
    
 
}