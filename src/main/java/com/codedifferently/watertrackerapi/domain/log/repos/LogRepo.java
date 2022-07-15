package com.codedifferently.watertrackerapi.domain.log.repos;

import com.codedifferently.watertrackerapi.domain.log.models.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository <Log, Long>{
}
