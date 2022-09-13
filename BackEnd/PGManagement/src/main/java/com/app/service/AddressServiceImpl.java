package com.app.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.Address;
import com.app.entities.AddressEntity;
import com.app.repository.AddressRepository;

@Service
@Transactional
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressRepository addrRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Address getAddressById(long id) {
		Optional<AddressEntity> addr = addrRepo.findById(id);
		if (addr.isPresent())
			return mapper.map(addr.get(), Address.class);
		return null;
	}

	@Override
	public Address addAddress(Address addr) {
		AddressEntity ae = addrRepo.save(mapper.map(addr, AddressEntity.class));
		System.out.println(ae.getId());
		return addr;
	}
}
