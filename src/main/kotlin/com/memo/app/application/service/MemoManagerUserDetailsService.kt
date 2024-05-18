package com.memo.app.application.service

import com.memo.app.domain.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class MemoManagerUserDetailsService(
    private val authenticationService: AuthenticationService
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails? {

        val user = authenticationService.findUser(username)
        return user?.let { MemoManagerUserDetails(user) }
    }
}

data class MemoManagerUserDetails(
    val userId: Int,
    val email: String?,
    @JvmField
    val password: String?,
) : UserDetails {

    constructor(user: User) : this(user.userId, user.email, user.password)

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return AuthorityUtils.createAuthorityList(this.email)
    }

    override fun isEnabled(): Boolean {
        return true;
    }

    override fun getUsername(): String? {
        return this.email
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String? {
        return this.password
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

}