package com.senai.usuario_database_oficial.services;

import com.senai.usuario_database_oficial.dtos.commons.AutenticarUsuarioDTO;
import com.senai.usuario_database_oficial.dtos.commons.MensagemDto;
import com.senai.usuario_database_oficial.dtos.usuario.*;
import com.senai.usuario_database_oficial.models.UsuarioModel;
import com.senai.usuario_database_oficial.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public MensagemDto adicionarUsuario(RequisicaoUsuarioDto requisicao){
        MensagemDto mensagem = new MensagemDto();

        Optional<UsuarioModel> usuarioModel = repository.findByLogin(requisicao.getLogin());
        if(usuarioModel.isPresent()){
            mensagem.setMensagem("[ERRO] ao cadastrar usuário");
            mensagem.setSucesso(false);
            return mensagem;
        }

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(requisicao.getNome());
        usuario.setLogin(requisicao.getLogin());
        usuario.setSenha(requisicao.getSenha());
        mensagem.setMensagem("Usuário cadastrado!");
        mensagem.setSucesso(true);

        repository.save(usuario);

        return mensagem;
    }

    public boolean atualizarUsuario(Long id, UsuarioAtualizarDto usuarioAtualizarDto){

        //--verificar se existe o usuario pelo id
        Optional<UsuarioModel> usuarioOptional = repository.findById(id);

        //--verificar se existe usuario com email
        Optional<UsuarioModel> usuarioOptionalLogin = repository.findByLogin(usuarioAtualizarDto.getLogin());

        //--se exister email cadastrado, retorna false
        if(usuarioOptionalLogin.isPresent() && !usuarioOptionalLogin.get().getId().equals(id)){
            return false;
        }

        //--se o email for inexistente, setta as informações no model
        if(usuarioOptional.isPresent()){

            UsuarioModel usuarioModel = usuarioOptional.get();

            if(!usuarioAtualizarDto.getNome().isBlank()){
                usuarioModel.setNome(usuarioAtualizarDto.getNome());
            }

            if(!usuarioAtualizarDto.getLogin().isBlank()){
                usuarioModel.setLogin(usuarioAtualizarDto.getLogin());
            }
            if(!usuarioAtualizarDto.getSenha().isBlank()){
                usuarioModel.setSenha(usuarioAtualizarDto.getSenha());
            }

        //-- persistir usuário no banco de dados
        repository.save(usuarioModel);
        return true;
    }

        return false;
        }

    public List<ConsultaUsuarioDto> listarUsuarios(){

        //Declara a lista de retorno
        List<ConsultaUsuarioDto>  listaConsultaUsuarioDto = new ArrayList<>();

        //Busca o usuarioModel do repository
        List<UsuarioModel> listaUsuarioModel = repository.findAll();

        for (UsuarioModel usuarioModel : listaUsuarioModel){
            //Converter usuarioModel para usuarioDTO
            ConsultaUsuarioDto consultaUsuarioDto = new ConsultaUsuarioDto();
            consultaUsuarioDto.setId(usuarioModel.getId());
            consultaUsuarioDto.setNome(usuarioModel.getNome());
            consultaUsuarioDto.setLogin(usuarioModel.getLogin());

            //Adicionar o DTO convertido a lista de retorno (que também é DTO)
            listaConsultaUsuarioDto.add(consultaUsuarioDto);

        }
        return listaConsultaUsuarioDto;
    }

    public RespostaUsuarioDto obterUsuarioPorId(Long id){
        RespostaUsuarioDto resposta = new RespostaUsuarioDto();
        Optional<UsuarioModel> usuarioOptional = repository.findById(id);

        if(usuarioOptional.isPresent()){
            UsuarioModel usuarioModel = usuarioOptional.get();
            resposta.setId(usuarioModel.getId());
            resposta.setNome(usuarioModel.getNome());
            resposta.setLogin(usuarioModel.getLogin());
            resposta.setSenha(usuarioModel.getSenha());
        }
        return resposta;
    }

    public UsuarioAtualizarDto atualizarUsuarioPorId(Long id){

        Optional<UsuarioModel> buscarUsuario = repository.findById(id);
        if(buscarUsuario.isEmpty()){
            return new UsuarioAtualizarDto();
        }
        return new UsuarioAtualizarDto(buscarUsuario.get());
    }

    public MensagemDto deletarUsuario(Long id){

        MensagemDto mensagem = new MensagemDto();
        Optional<UsuarioModel> usuarioModelIdPesquisado = repository.findById(id);

        if(usuarioModelIdPesquisado.isEmpty()){
            mensagem.setMensagem("[ERRO] - ID não encontrado!");
            mensagem.setSucesso(false);
            return mensagem;
        }
        repository.delete(usuarioModelIdPesquisado.get());
        mensagem.setMensagem("Usuário excluido com sucesso!");
        mensagem.setSucesso(true);
        return mensagem;
    }

    public MensagemDto autenticarUsuario(RequisicaoUsuarioDto dados){
        MensagemDto mensagem = new MensagemDto();

        Optional<UsuarioModel> usuarioOptional = repository.findByLogin(dados.getLogin());

        if(usuarioOptional.isPresent()){
            if(dados.getSenha().equals(usuarioOptional.get().getSenha())){
                mensagem.setMensagem("Usuário autenticado com sucesso!");
                mensagem.setSucesso(true);
                return mensagem;
            }
        }

        mensagem.setMensagem("[ERRO] Login ou senha incorreto!");
        mensagem.setSucesso(false);
        return mensagem;
    }

    public MensagemDto autenticarUsuario2(AutenticarUsuarioDTO dados){
        MensagemDto mensagem = new MensagemDto();

        Optional<UsuarioModel> usuarioOptional = repository.findByLogin(dados.getLogin());

        if(usuarioOptional.isPresent()){
            if(dados.getSenha().equals(usuarioOptional.get().getSenha())){
                mensagem.setMensagem("Usuário autenticado com sucesso!");
                mensagem.setSucesso(true);
                return mensagem;
            }
        }

        mensagem.setMensagem("[ERRO] Login ou senha incorreto!");
        mensagem.setSucesso(false);
        return mensagem;
    }

    public ConsultaUsuarioDto buscarUsuarioPorId3(Long id) {
        ConsultaUsuarioDto usuarioDTO = new ConsultaUsuarioDto();

        Optional<UsuarioModel> usuarioModelIdPesquisado = repository.findById(id);

        if(usuarioModelIdPesquisado.isEmpty()) {
            return new ConsultaUsuarioDto(0L);
        }

        return usuarioDTO.of(usuarioModelIdPesquisado.get());
    }

    public UsuarioSessaoDTO autenticarUsuario3(AutenticarUsuarioDTO dados){
       UsuarioSessaoDTO usuarioSessaoDTO = new UsuarioSessaoDTO();

        Optional<UsuarioModel> usuarioOptional = repository.findByLogin(dados.getLogin());

        if(usuarioOptional.isPresent() && usuarioOptional.get().getSenha().equals(dados.getSenha())) {
            usuarioSessaoDTO.setId(usuarioOptional.get().getId());
            usuarioSessaoDTO.setNome(usuarioOptional.get().getNome());
        }

        return usuarioSessaoDTO;
    }
}
