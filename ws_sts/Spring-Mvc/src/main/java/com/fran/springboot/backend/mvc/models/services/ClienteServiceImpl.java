package com.fran.springboot.backend.mvc.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fran.springboot.backend.mvc.models.dao.IclienteDao;
import com.fran.springboot.backend.mvc.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IclienteService {

	@Autowired  // Para incorporar un componente dentro de otro componente
	private IclienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true)  // Auto-exiges que dentro del método no usarás nada que pueda modificar los datos
	public List<Cliente> findAll() {
		return (List<Cliente>)clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

}
