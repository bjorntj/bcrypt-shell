package no.havleik.bcryptshell.commands;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class BCryptCommand {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public BCryptCommand(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @ShellMethod(key = "encode",value = "Bcrypt encode password/string")
    public String cryptPassword(@ShellOption(value = { "-p" }) String password) {
        String encoded = bCryptPasswordEncoder.encode(password);
        return "{bcrypt}" + encoded;
    }
}
