package fr.leroideskiwis.omegabot.user;

import net.dv8tion.jda.api.entities.Member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Manage the users
 */
public class UserManager {

    private final List<OmegaUser> users = new ArrayList<>();

    /**
     * Convert a discord member to an OmegaUser (if the user is not in the list, it will be added)
     * @param member the discord member
     * @return the OmegaUser
     */
    public OmegaUser from(Member member){
        return users.stream().filter(omegaUser -> omegaUser.isMember(member)).findFirst().orElseGet(() -> {
            OmegaUser user = new OmegaUser(member);
            try {
                user.load();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            users.add(user);
            return user;
        });
    }
}
