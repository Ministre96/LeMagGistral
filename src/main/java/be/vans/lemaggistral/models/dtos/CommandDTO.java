package be.vans.lemaggistral.models.dtos;

import be.vans.lemaggistral.models.entities.Client;
import be.vans.lemaggistral.models.entities.Command;
import be.vans.lemaggistral.models.entities.Command_Article;
import be.vans.lemaggistral.models.entities.Status;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class CommandDTO {
    private Date dateCommand;
    private Date dateReceipt;
    private Status status;

    private List<Command_Article> articles;
    private Client client;

    public static CommandDTO toDTO(Command command){
        CommandDTO.CommandDTOBuilder dto = CommandDTO.builder();
        return dto
                .dateCommand(command.getDateCommand())
                .dateReceipt(command.getDateReceipt())
                .status(command.getStatus())
                .client(command.getClient())
                .articles(command.getCommandArticles())
                .build();
    }
}
