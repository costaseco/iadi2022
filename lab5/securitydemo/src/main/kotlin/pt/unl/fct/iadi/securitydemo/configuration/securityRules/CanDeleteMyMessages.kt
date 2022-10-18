package pt.unl.fct.iadi.securitydemo.configuration.securityRules

import org.intellij.lang.annotations.Language
import org.springframework.security.access.prepost.PreAuthorize

@PreAuthorize(CanDeleteMyMessages.condition)
annotation class CanDeleteMyMessages {
    companion object {
        @Language("SpEL")
        const val condition = "hasRole('ADMIN') OR @mySecurityService.myMessage(principal,#id)"
    }
}
