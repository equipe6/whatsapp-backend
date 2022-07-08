package br.edu.unisinos.whatsapp.repositories;

import br.edu.unisinos.whatsapp.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
