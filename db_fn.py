import psycopg2

def connect():
    """Se connecte à la base de données PostgreSQL et retourne la connexion"""
    try:
        db_params = {
            'dbname': 'api',
            'user': 'postgres',
            'password': 'admin',
            'host': 'localhost',
            'port': '5432'
        }
        conn = psycopg2.connect(**db_params)
        print("Connexion à la base de données PostgreSQL réussie!")
        return conn
    except (Exception, psycopg2.Error) as error:
        print("Erreur lors de la connexion à PostgreSQL:", error)
        return None

def fetch_data(conn):
    """Récupère des données depuis la table customer dans la base de données"""
    try:
        cursor = conn.cursor()
        cursor.execute("SELECT email, society_name FROM api.public.customer WHERE id IN (1, 2, 3);")
        rows = cursor.fetchall()
        cursor.close()
        return rows
    except (Exception, psycopg2.Error) as error:
        print("Erreur lors de la récupération des données depuis la table customer:", error)
        return None

def create_view(conn, view_name, sql_query):
    """Crée une vue dans la base de données"""
    try:
        cursor = conn.cursor()
        cursor.execute(f"CREATE OR REPLACE VIEW {view_name} AS {sql_query};")
        conn.commit()
        cursor.close()
        print(f"Vue '{view_name}' créée avec succès.")
    except (Exception, psycopg2.Error) as error:
        conn.rollback()
        print(f"Erreur lors de la création de la vue '{view_name}':", error)

def create_materialized_view(conn, view_name, sql_query):
    """Crée une vue matérialisée dans la base de données"""
    try:
        cursor = conn.cursor()
        cursor.execute(f"CREATE MATERIALIZED VIEW {view_name} AS {sql_query};")
        conn.commit()
        cursor.close()
        print(f"Vue matérialisée '{view_name}' créée avec succès.")
    except (Exception, psycopg2.Error) as error:
        conn.rollback()
        print(f"Erreur lors de la création de la vue matérialisée '{view_name}':", error)

def fetch_data_from_view(conn, view_name):
    """Récupère des données depuis une vue dans la base de données"""
    try:
        cursor = conn.cursor()
        cursor.execute(f"SELECT * FROM {view_name};")
        rows = cursor.fetchall()
        cursor.close()
        return rows
    except (Exception, psycopg2.Error) as error:
        print(f"Erreur lors de la récupération des données depuis la vue '{view_name}':", error)
        return None

def main():
    # Se connecter à la base de données
    conn = connect()
    if conn is None:
        return
    
    try:
        # Exemple: Créer une vue
        create_view_query = """
            SELECT email, society_name
            FROM api.public.customer
            WHERE id IN (1, 2, 3);
        """
        create_view(conn, 'ma_vue', create_view_query)

        # Exemple: Créer une vue matérialisée
        create_materialized_view_query = """
            SELECT email, society_name
            FROM api.public.customer
            WHERE id = 5;
        """
        create_materialized_view(conn, 'ma_vue_materialisee', create_materialized_view_query)
        
        # Exemple: Récupérer des données depuis une vue
        view_name = 'ma_vue'
        data = fetch_data_from_view(conn, view_name)
        if data:
            print(f"Données de la vue '{view_name}':")
            for row in data:
                print(row)

        # Exemple: Récupérer des données depuis la table customer
        data = fetch_data(conn)
        if data:
            print("\nDonnées depuis la table customer:")
            for row in data:
                print(row)

    except psycopg2.Error as e:
        print("Erreur psycopg2 générale:", e)

    finally:
        # Fermer la connexion à la base de données
        if conn is not None:
            conn.close()

if __name__ == "__main__":
    main()
