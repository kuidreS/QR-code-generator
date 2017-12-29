package com.vserdiuk.qr.repository;

import com.vserdiuk.qr.entity.Qr;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vserdiuk on 12/21/17.
 */

public interface QrRepository extends CrudRepository<Qr, Long> {
}
