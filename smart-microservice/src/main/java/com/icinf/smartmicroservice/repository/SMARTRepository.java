package com.icinf.smartmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icinf.smartmicroservice.entity.SMART;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

@Repository
public interface SMARTRepository extends JpaRepository<SMART, Integer>{
    // private List<SMART> paths = new ArrayList<SMART>(Arrays.asList(new SMART(1, 'b', 0),
    // new SMART(2, 'b', 1),
    // new SMART(3, 'b', 2),
    // new SMART(4, 'd', 0),
    // new SMART(5, 'd', 1),
    // new SMART(6, 'd', 2),
    // new SMART(7, 'q', 0),
    // new SMART(8, 'q', 1),
    // new SMART(9, 'q', 2),
    // new SMART(10, 'p', 0),
    // new SMART(11, 'p', 1),
    // new SMART(12, 'p', 2)));
}