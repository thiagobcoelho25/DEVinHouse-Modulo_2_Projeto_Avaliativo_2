-- DELETE FROM consulta;
-- DELETE FROM ENDERECO;
-- DELETE FROM exame;
-- DELETE FROM paciente;
-- DELETE FROM paciente_alergias;
-- DELETE FROM paciente_cuidados;
-- DELETE FROM usuario;

    INSERT INTO ENDERECO (id, bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia)
values
    (default, 'TESTE ORACLE SQL', '28199', 'TESTE CIDADE ORACLE', 'nenhum', 'ESTADO ORACLE', 'Nenhum', 9, 'Nenhum');

    insert into endereco
        (id, bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia)
    values
        (default, 'Bairro 2', '72859380', 'Somewhere Beyond Time & Space', 'Sem Complemento', 'Imaginario', 'Rua sem nome', 45, 'nenhum ponto referencia');

    insert into endereco
        (id, bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia)
    values
        (default, 'Bairro 3', '31231', 'Vitoria', 'Sem Complemento', 'ES', 'Rua 3', 89, 'nenhum ponto referencia');

    insert into endereco
        (id, bairro, cep, cidade, complemento, estado, logradouro, numero, ponto_referencia)
    values
        (default, 'Bairro 4', '58303355', 'São Paulo', 'Sem Complemento', 'SP', 'Rua 4', 33, 'nenhum ponto referencia');
