package com.example.demo.service;

import com.example.demo.models.ApplyLeave;
import com.example.demo.models.Leaves;

public interface LeaveService {
    void reduceLeave(ApplyLeave applyLeave
    );
    void saveLeaves(Leaves leaves);

    Leaves getByEmpId(int id);
}
