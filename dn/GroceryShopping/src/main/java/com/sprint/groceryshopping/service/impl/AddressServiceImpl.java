package com.sprint.groceryshopping.service.impl;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.groceryshopping.dto.AddressDTO;
import com.sprint.groceryshopping.exception.RecordNotFoundException;
import com.sprint.groceryshopping.model.Address;
import com.sprint.groceryshopping.repositry.AddressDAO;
import com.sprint.groceryshopping.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{

	 @Autowired
	  public AddressDAO addressRepository;

	 public static AddressDTO entityToDTO(Address address) {
			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setAddressId(address.getAddressId());
			addressDTO.setCountry(address.getCountry());
			addressDTO.setState(address.getState());
			addressDTO.setDistrict(address.getDistrict());
			addressDTO.setPinCode(address.getPinCode());
			
			return addressDTO;
			
	 }
	 
	 public static Address DTOToEntity(AddressDTO addressDTO) {
			Address address = new Address();
			address.setAddressId(addressDTO.getAddressId());
			address.setCountry(addressDTO.getCountry());
			address.setState(addressDTO.getState());
			address.setDistrict(addressDTO.getDistrict());
			address.setPinCode(addressDTO.getPinCode());
			
			return address;
	 }


			
	@Override
	public AddressDTO add(AddressDTO addressDTO) {
		 Address address = DTOToEntity(addressDTO);
		Address addressReturn=addressRepository.save(address);
		return entityToDTO(addressReturn);
	}

	@Override
	public AddressDTO update(AddressDTO addressDTO) {
		Address address = DTOToEntity(addressDTO);
		Address addressReturn=addressRepository.save(address);
		return entityToDTO(addressReturn);
	}

	@Override
	public AddressDTO delete(Integer addressId) throws RecordNotFoundException {
		try {
			addressRepository.deleteById(addressId);
			}
			catch(Exception e) {
				throw new RecordNotFoundException("No records found.");
			}
		
		return null;
	}

	@Override
	public AddressDTO findById(Integer addressId) {
	Optional<Address> address = addressRepository.findById(addressId);
		
		return entityToDTO(address.get());
	}
	@Override
	public List<AddressDTO> getAddress() {
		
		List<AddressDTO> addressReturn = new ArrayList<>();
		List<Address> addresses = addressRepository.findAll();
		for (Address a : addresses ) {
			addressReturn.add(entityToDTO(a));
		}
		
		return addressReturn;
	}


	
	}
