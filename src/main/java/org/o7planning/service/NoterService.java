package org.o7planning.service;

import java.util.List;

import org.o7planning.model.Noter;

public interface NoterService {
	List < Noter > getAllNoter();
    void saveNoter(Noter noter);
    Noter getNoterById(long id);
    void deleteNoterById(long id);
}
