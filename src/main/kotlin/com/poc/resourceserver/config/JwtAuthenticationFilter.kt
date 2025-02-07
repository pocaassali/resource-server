package com.poc.resourceserver.config

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtUtil : JwtUtil,
    private val customUserDetailsService: CustomUserDetailsService
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain
    ) {
        // Extraire le token Bearer du header Authorization
        val header = request.getHeader("Authorization")
        println(header)

        // Si le header est présent et commence par "Bearer "
        if (header != null && header.startsWith("Bearer ")) {
            val token = header.substring(7) // Récupère le token (sans le "Bearer ")
            println(token)

            try {
                println("try")
                //if (!jwtUtil.isTokenExpired(token)) {
                    val username = jwtUtil.extractUsername(token)
                    val rolesFromToken = jwtUtil.extractRoles(token)
                println(rolesFromToken)
                val authorities = rolesFromToken.map { SimpleGrantedAuthority(it) }
                    //val customUserDetails = customUserDetailsService.loadUserByUsername(username)
                    //println(customUserDetails) //userDetails are hardcoded for now
                    val authentication = UsernamePasswordAuthenticationToken(
                        username, null, authorities,
                    )
                    SecurityContextHolder.getContext().authentication = authentication
                //}
            } catch (e: Exception) {
                // Gérer l'exception si nécessaire (par exemple un token invalide ou expiré)
                response.status = HttpServletResponse.SC_UNAUTHORIZED
                response.writer.write("Invalid or expired token")
                return
            }
        }

        // Passer à la requête suivante dans la chaîne de filtres
        filterChain.doFilter(request, response)
    }
}