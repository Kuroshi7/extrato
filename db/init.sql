CREATE TABLE transacoes (
    id VARCHAR(50) PRIMARY KEY,
    descricao TEXT,
    data DATE,
    valor NUMERIC(15,2),
    tipo TEXT,
    validacao TEXT DEFAULT 'pendente'
);

INSERT INTO transacoes VALUES
('674857b8c7980c0d47fdc535','description','2023-01-26',33.33,'DEPOSITO_BOLETO','pendente'),
('674857b8c7980c0d47fdc4dc','description','2023-02-02',3783.00,'PAGAMENTO','pendente'),
('674857b8c7980c0d47fdc4db','description','2023-02-02',109.99,'PAGAMENTO','pendente'),
('674857b8c7980c0d47fdc4d9','description','2023-02-02',100.00,'PAGAMENTO','pendente'),
('674857b8c7980c0d47fdc4d7','description','2023-02-02',14.27,'PAGAMENTO','pendente'),
('674857b8c7980c0d47fdc4d5','description','2023-02-02',250.00,'PAGAMENTO','pendente'),
('674857b8c7980c0d47fdc4d4','description','2023-02-03',34.33,'PAGAMENTO','pendente'),
('674857b8c7980c0d47fdc48b','description','2023-02-07',31.00,'PIX','pendente'),
('674857b8c7980c0d47fdc48a','description','2023-02-07',10.00,'PIX','pendente'),
('674857b8c7980c0d47fdc553','description','2023-02-10',1.02,'INVESTIMENTO','pendente'),
('674857b8c7980c0d47fdc552','description','2023-02-10',1.02,'INVESTIMENTO','pendente'),
('674857b8c7980c0d47fdc551','description','2023-02-10',1.03,'INVESTIMENTO','pendente'),
('674857b8c7980c0d47fdc550','description','2023-02-10',1.01,'INVESTIMENTO','pendente'),
('674857b8c7980c0d47fdc54f','description','2023-02-10',1.02,'INVESTIMENTO','pendente'),
('674857b8c7980c0d47fdc54e','description','2023-02-10',1.02,'INVESTIMENTO','pendente'),
('674857b8c7980c0d47fdc54d','description','2023-02-10',1.02,'INVESTIMENTO','pendente'),
('674857b8c7980c0d47fdc54c','description','2023-02-10',1.02,'INVESTIMENTO','pendente'),
('674857b8c7980c0d47fdc54b','description','2023-02-10',1.02,'INVESTIMENTO','pendente'),
('674857b8c7980c0d47fdc54a','description','2023-02-10',0.52,'INVESTIMENTO','pendente'),
('674857b8c7980c0d47fdc489','description','2023-02-13',45.01,'PIX','pendente'),
('674857b8c7980c0d47fdc4d2','description','2023-02-13',32.49,'PAGAMENTO','pendente'),
('674857b8c7980c0d47fdc488','description','2023-02-13',1864.11,'PIX','pendente'),
('674857b8c7980c0d47fdc487','description','2023-02-13',1864.11,'PIX','pendente'),
('674857b8c7980c0d47fdc486','description','2023-02-13',1864.11,'PIX','pendente'),
('674857b8c7980c0d47fdc485','description','2023-02-13',1864.11,'PIX','pendente'),
('674857b8c7980c0d47fdc484','description','2023-02-13',1432.87,'PIX','pendente'),
('674857b8c7980c0d47fdc483','description','2023-02-13',6116.03,'PIX','pendente'),
('674857b8c7980c0d47fdc4d1','description','2023-02-14',31.73,'PAGAMENTO','pendente'),
('674857b8c7980c0d47fdc482','description','2023-02-15',5.01,'PIX','pendente'),
('674857b8c7980c0d47fdc481','description','2023-02-15',3380.79,'PIX','pendente');