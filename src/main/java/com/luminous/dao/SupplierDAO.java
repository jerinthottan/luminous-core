package com.luminous.dao;

import java.util.List;

import com.luminous.model.Supplier;

public interface SupplierDAO {

	boolean addSupplier(Supplier supplier);

	boolean deleteSupplier(Supplier supplier);

	boolean updateSupplier(Supplier supplier);

	List<Supplier> listSuppliers();

	Supplier getSupplier(int supplierID);

}
