package com.example.correct.Easy.infra.security.implementations;

import com.example.correct.Easy.core.application.usecase.contracts.user.GetUserByIdContract;
import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.infra.exception.typo.primaries.InternalServerErroInfraException;
import com.example.correct.Easy.infra.exception.typo.primaries.NotFoundInfraException;
import com.example.correct.Easy.infra.persistence.repository.UserRepository;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserDetailsServiceImpl implements UserDetailsService{

    private final GetUserByIdContract getUserById;

    public UserDetailsServiceImpl(GetUserByIdContract getUserById) {
        this.getUserById = getUserById;
    }

    @Override
    public UserDetails loadUserByUsername(String idUserInStringFormat) throws UsernameNotFoundException {
        try{
          if (!idUserInStringFormat.equals("null")){
              Long idConverted=Long.valueOf(idUserInStringFormat);
              UserDomain entity=getUserById.execute(idConverted);
              UserDetailsImpl userDetails=new UserDetailsImpl(entity);
              return userDetails;
          }
          throw new InternalServerErroInfraException("o id contido no token está nulo quando convertido para String no loadByUsername.");
        }
        catch (AuthenticationException e){
         throw new UsernameNotFoundException("ocorreu o seguinte problema: "+e.getMessage());
        }
    }
}
