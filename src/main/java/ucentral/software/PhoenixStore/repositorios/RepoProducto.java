package ucentral.software.PhoenixStore.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucentral.software.PhoenixStore.entidades.Productos;

@Repository
public interface RepoProducto extends JpaRepository<Productos, Long> {
}


