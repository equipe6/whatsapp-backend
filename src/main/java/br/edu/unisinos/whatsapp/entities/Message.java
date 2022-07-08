package br.edu.unisinos.whatsapp.entities;


import br.edu.unisinos.whatsapp.enums.DirectionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@Table(name = "message", schema = "public")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    public Message() {
        this.buildChannel();
    }

    @Id
    @SequenceGenerator(name = "message_entity_seq", sequenceName = "message_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_entity_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "message_to", nullable = false)
    private String to;

    @Column(name = "message_from", nullable = false)
    private String from;

    @Column(name = "message_body", nullable = false)
    private String body;

    @Enumerated(EnumType.STRING)
    @Column(name = "direction", nullable = false)
    private DirectionEnum direction;

    @Column(name = "channel", nullable = false)
    private String channel;

    @CreationTimestamp
    @Column(name = "create_date_time", nullable = false)
    private LocalDateTime createDateTime;

    public String buildChannel() {
        if (direction == null) {
            return this.channel;
        }
        if (DirectionEnum.IN.equals(direction)) {
            this.channel = "" + to + from;
        } else {
            this.channel = "" + from + to;
        }
        return this.channel;
    }

    public String getChannel() {
        return this.buildChannel();
    }


}
