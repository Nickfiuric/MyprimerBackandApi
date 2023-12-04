package com.utsem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utsem.Model.Producto;
import java.util.Optional;
import java.util.UUID;

//Es una interfas donde se tendra todos mis metodos abstacrtos//
//realizar opciones sobre la tabla de BD//
public interface ProductoRepository extends JpaRepository<Producto, Long > {
	Optional<Producto> findByCodigo(String codigo);
	Optional<Producto> findByUuid(UUID uuid);
}
