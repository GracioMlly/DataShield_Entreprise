# Utilisez l'image PostgreSQL existante comme base
FROM postgres:15.7

# Mise à jour des paquets et installation de Python et PostgreSQL PL/Python
RUN apt-get update \
    && apt-get install -y \
        python3 \
        postgresql-contrib \
        postgresql-plpython3-15


# Démarrez PostgreSQL
CMD ["postgres"]
