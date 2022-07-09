package br.edu.unisinos.whatsapp.repositories;

import br.edu.unisinos.whatsapp.entities.WebhookMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebhookMessageRepository extends JpaRepository<WebhookMessage, Long> {

}