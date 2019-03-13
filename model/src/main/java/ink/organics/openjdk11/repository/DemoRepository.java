package ink.organics.openjdk11.repository;

import ink.organics.openjdk11.model.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DemoRepository extends JpaRepository<Demo, String>, JpaSpecificationExecutor<Demo> {

}
