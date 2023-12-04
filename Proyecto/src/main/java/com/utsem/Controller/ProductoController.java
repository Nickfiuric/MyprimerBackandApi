package com.utsem.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utsem.Model.Producto;
import com.utsem.Repository.ProductoRepository;
//Peticiones del cliente //

@RestController
@RequestMapping("productos")
public class ProductoController {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@PostMapping("guardar")
 public String guarda(@RequestBody Producto producto) {  //insertarenlaBD//
	 productoRepository.save(producto);  //guaradarProducto//
	 return "Producto Guaradado";
 }
 
	@GetMapping("consultarProductos") //ParaEntrarPorMedioDeLaURL//
	public List<Producto> cargaTodos(){ //GuaradarenLista//
		return productoRepository.findAll(); //DevolverListadeProductos//
	}
	@DeleteMapping("Eliminar")
	public String Eliminar(@RequestBody Producto producto) {
		Optional<Producto> pro = productoRepository.findById(producto.getId());
		if(pro.isPresent()) {
			productoRepository.delete(pro.get());
			return"Producto eliminado";
		}
		else {
			return "Producto no encontrado";
		}	
	}
	@PutMapping("Actualizar")
	public String Actualizar(@RequestBody Producto producto) {
		Optional<Producto> pro =  productoRepository.findById(producto.getId());
		if(pro.isPresent()) {
			pro.get().setDescripcion(producto.getDescripcion());
			pro.get().setCodigo(producto.getCodigo());
			pro.get().setEstatus(producto.getEstatus());
			pro.get().setExistencias(producto.getExistencias());
			pro.get().setPrecio(producto.getPrecio());
			productoRepository.save(pro.get());
			return"Producto Actualizado";
		}
		else {
			return "Producto no encontrado";
		}	
	}
	
	
}

