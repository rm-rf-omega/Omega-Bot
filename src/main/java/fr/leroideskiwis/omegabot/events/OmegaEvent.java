package fr.leroideskiwis.omegabot.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface OmegaEvent {
    boolean isFinished();
    boolean isApplicable(MessageReceivedEvent event);
    void apply(MessageReceivedEvent event);

    void end();
}
