import React, { useState, useEffect } from 'react';
import axios from 'axios';

function MesaList() {
  const [mesas, setMesas] = useState([]);

  useEffect(() => {
    async function fetchMesas() {
      try {
        const response = await axios.get('http://localhost:8080/api/mesas/lista');
        setMesas(response.data);
      } catch (error) {
        console.error('Erro ao buscar mesas:', error);
      }
    }

    fetchMesas();
  }, []);

  return (
    <div>
      <h1>Lista de Mesas</h1>
      <ul>
        {mesas.map(mesa => (
          <li key={mesa.id}>
            <strong> Quantidade de assentos: </strong> {mesa.qtdAssentosMax}
            - <strong>informação Adicional:</strong>  {mesa.infoAdicional}
            - <strong>Status: </strong> {mesa.status}
            - <strong>Nome do Restaurante: </strong> {mesa.nomeRestaurante}
            - <strong>Localizacao: </strong> {mesa.localizacao}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default MesaList;
