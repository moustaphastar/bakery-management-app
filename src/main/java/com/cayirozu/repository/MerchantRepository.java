package com.cayirozu.repository;

import com.cayirozu.db.entity.Merchant;
import org.springframework.data.repository.CrudRepository;

public interface MerchantRepository extends CrudRepository<Merchant, Integer> {
}
