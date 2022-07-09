package br.edu.unisinos.whatsapp.repositories;

import br.edu.unisinos.whatsapp.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByChannelOrderByCreateDateTimeAsc(String channel);

    @Query("SELECT DISTINCT m.channel FROM Message m")
    List<String> findDistinctChannel();
}
