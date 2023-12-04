package com.utsem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utsem.DTO.ProductoDTO;
import com.utsem.DTO.VentaDTO;
import com.utsem.services.VentaService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("ventas")
public class ventacontroller {
	@Autowired
	VentaService ventaService;
	// Busca mi poroducto y lo agrega a la venta
	@PostMapping("buscarCodigo")
	public String buscaCodigo(HttpSession session, @RequestBody ProductoDTO  productoDTO) { //me_deves_de_mandar_un_objeto_de_ProductoDTO
		System.out.println("JSESSIONID: "+ session.getId());
		System.out.println("Codigo a buscar: " + productoDTO.getCodigo());
		System.out.println("Peticion recibida");
	return ventaService.buscarproductoporcodigo(session, productoDTO);
	
	}
	//Controlador que ejecuta consultar la venta
	@PostMapping("consultarVenta")
	public VentaDTO consultaVenta(HttpSession session) {
	System.out.print("JSESSIONID:"+ session.getId());
	return ventaService.consultaVenta(session);
	
	}
	//Controlador para Limpiar mi tabla de ventas
	@PostMapping("LimpiarVenta")
	public String LimpiaVenta(HttpSession session) {
		System.out.print("JSESSIONID:"+ session.getId());
		return ventaService.LimpiaVenta(session);
	}
	//Controlador de eliminar mis detalles en las ventas
	@PostMapping("eliminarDetalle/{pos}")
	public String eliminaDetalle(HttpSession session,@PathVariable int pos ) {
		System.out.print("JSESSIONID:"+ session.getId());
		return ventaService.eliminarDetalle(session,pos);
	}
		@PostMapping("guardaVenta")
		public String GuardarVenta(HttpSession session) {
			System.out.print("JSESSIONID:"+ session.getId());
			return ventaService.guardaVenta(session);
		}
		
		@PostMapping("SumarDetalle/{Sum}")
		public String SumarDetalles(HttpSession session,@PathVariable int Sum ) {
			System.out.print("JSESSIONID:"+ session.getId());
			return ventaService.SumarDetalle(session,Sum);
		}
		
}
