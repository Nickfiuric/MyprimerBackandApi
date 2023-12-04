package com.utsem.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.utsem.DTO.DetalleVentaDTO;
import com.utsem.DTO.ProductoDTO;
import com.utsem.DTO.VentaDTO;
import com.utsem.Model.DetalleVenta;
import com.utsem.Model.Producto;
import com.utsem.Model.venta;
import com.utsem.Repository.ProductoRepository;
import com.utsem.Repository.VentaRepository;
import com.utsem.Repository.detVentaRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class VentaService {
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	detVentaRepository detVentaRepository;
	@Autowired
	VentaRepository ventaRepository;
	@Autowired
	ModelMapper modelMapper;

	public String buscarproductoporcodigo(HttpSession session, @RequestBody ProductoDTO productoDTO) {
		// Obtiene_un_producto_por_codigo_si_es_que_existe
		Optional<Producto> pro = productoRepository.findByCodigo(productoDTO.getCodigo());
		// Si_el_producto_existe_y_esta_presente
		if (pro.isPresent()) {
			// Si_aun_no e_crado_mi_atributo_miVenta
			if (session.getAttribute("MiVenta") == null) {
				// Creo_una_nueva_venta_en_el_atributo_miVenta
				session.setAttribute("MiVenta", new VentaDTO());
			}

			// Obteno el atributi miventa, lo convierte en VentaDto
			VentaDTO ventaDTO = (VentaDTO) session.getAttribute("MiVenta");
			if (ventaDTO.getVentarealizada()) {
				session.setAttribute("MiVenta", ventaDTO = new VentaDTO());
			}

			// Obtengo_el_atributo_miVent_lo_converto_en VentaDTO y_lo _guardo
			Boolean existe = false;
			for (int i = 0; i < ventaDTO.getDetalles().size(); i++) {
				DetalleVentaDTO det = ventaDTO.getDetalles().get(i); // manda un detalle de venta DTO

				if (det.getProductoDTO().getUuid().compareTo(pro.get().getUuid()) == 0) { //
					det.setCantidad(det.getCantidad() + 1); // La cantidad actual mas uno se vuelve a guardar en nuestra
															// cantidad
					det.setSubtotal((double) (det.getCantidad() * det.getPrecio())); //
					existe = true;
					break;
				}
			}
			if (!existe) {

				DetalleVentaDTO detDTO = new DetalleVentaDTO();
				detDTO.setCantidad((float) 1);
				detDTO.setPrecio(pro.get().getPrecio());
				detDTO.setSubtotal((double) (detDTO.getCantidad() * detDTO.getPrecio()));
				detDTO.setProductoDTO(modelMapper.map(pro.get(), ProductoDTO.class));
				ventaDTO.getDetalles().add(detDTO);
			}
			double suma = 0d; // Linea de codigo que hace la suma de los productos para sacar el tota.
			for (int i = 0; i < ventaDTO.getDetalles().size(); i++)
				suma += ventaDTO.getDetalles().get(i).getSubtotal(); // Suma el subtotal para dar el valor del total
			ventaDTO.setTotal(suma);
			return "Producto encontrado y Agregando a la venta";
		} else {
			
			return "Producto no encontrado";
		}
	}

	public VentaDTO consultaVenta(HttpSession session) {
		if (session.getAttribute("MiVenta") == null) {
			// Creo_una_nueva_venta_en_el_atributo_miVenta
			session.setAttribute("MiVenta", new VentaDTO());
		}
		return (VentaDTO) session.getAttribute("MiVenta");
	}

	public String LimpiaVenta(HttpSession session) {
		session.setAttribute("MiVenta", new VentaDTO());
		return "Venta se encuentra basio";

	}

	public String eliminarDetalle(HttpSession session, int pos) {
		VentaDTO ventaDTO = (VentaDTO) session.getAttribute("MiVenta");
		ventaDTO.getDetalles().remove(pos);
		double resta = 0d;
		for (int i = 0; i < ventaDTO.getDetalles().size(); i++)	
			resta += ventaDTO.getDetalles().get(i).getSubtotal(); // Suma el subtotal para dar el valor del total
		ventaDTO.setTotal(resta);
		return "Detalle eliminado";

	}

	public String guardaVenta(HttpSession session) {
		// Obtenemos de la sesion la venta del clinte en ventaDTO
		VentaDTO ventaDTO = (VentaDTO) session.getAttribute("MiVenta");
		// Pasamos la informacion del DTO a la entidad PAsa todo
		venta miventa = modelMapper.map(ventaDTO, venta.class);
		// Guardamos la venta en mi repositorio
		ventaRepository.save(miventa);
		// Recorremos toda mi lista de detalles
		for (int i = 0; i < ventaDTO.getDetalles().size(); i++) {
			// Accediendo uno por uno a cada detalle
			DetalleVentaDTO det = ventaDTO.getDetalles().get(i);
			// Pasamos la indormacion de DTO a la entidad
			DetalleVenta miDetalle = modelMapper.map(det, DetalleVenta.class);
			// Configuramos la venta en mi detalle
			miDetalle.setVenta(miventa);
			// Volvo a consultar la entidad venta en mi detalle
			Producto pro = productoRepository.findByUuid(det.getProductoDTO().getUuid()).get();
			// Configuramos el detalle en el repositorio
			miDetalle.setProducto(pro);
			// Guardamos el detalle en el repositorio
			detVentaRepository.save(miDetalle);
			det.setDetalleGuardar(true);
		}

		ventaDTO.setVentarealizada(true);
		return "Venta Guardada";
	}
	
	public String SumarDetalle(HttpSession session, int Sum) {
		VentaDTO ventaDTO = (VentaDTO) session.getAttribute("MiVenta");
		// Suma mi producto y tambien el subtotal
		
		DetalleVentaDTO det = ventaDTO.getDetalles().get(Sum); // manda un detalle de venta DTO
		det.setCantidad(det.getCantidad() + 1); // La cantidad actual mas uno se vuelve a guardar en nuestra
												// cantidad
		det.setSubtotal((double) (det.getCantidad() * det.getPrecio())); //
		double suma = 0d;
		for (int i = 0; i < ventaDTO.getDetalles().size(); i++) {
			suma += ventaDTO.getDetalles().get(i).getSubtotal(); // Suma el subtotal para dar el valor del total
			ventaDTO.setTotal(suma);
		}
			
		return "Detalle Sumo Uno";

	}
}
