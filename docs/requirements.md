## Application Colis Pro – Cahier des charges (FR)

### 1. Contexte et objectifs
L’application vise à professionnaliser un service d’expédition type poste/express (inspiré DHL) pour:
- **Clients passagers**: paiements au guichet, reçu immédiat, étiquette collée.
- **Clients abonnés**: compte client, conditions tarifaires spécifiques, **facturation mensuelle en TND**.
- **Routage mondial**: choix de la destination en fonction du **code postal** et du **bureau** destinataire.
- **Opérations guichet**: gestion des **vacations** (ouvertures/fermetures), encaissements, **arrêt de situation** par agent.

### 2. Rôles et permissions
- **Admin**: paramétrage (bureaux, tarifs, taxes), gestion des rôles, reporting global, export.
- **Agent de guichet**: créer envois, encaisser, éditer étiquettes et reçus, clôturer la vacation.
- **Client abonné**: Espace client (historique, suivi, factures, paiement en ligne si activé).

### 3. Entités métier principales
- **Client**: `passager` ou `abonné`, coordonnées, NIF/identifiants fiscaux (si abonné).
- **Adresse**: pays, ville, code postal, rue, contact.
- **Bureau**: code, adresse, fuseau horaire, caisse.
- **Envoi (Shipment)**: expéditeur, destinataire, contenu, poids/volumétrie, services (assurance, express), **tracking**.
- **Colis (Parcel)**: 1..n par envoi (dimensions, poids).
- **Tarifs**: grilles par pays/zone/poids/volumétrie, surcharges carburant, options.
- **Facture**: entête, lignes (envois), taxes (TVA), montants en **TND**.
- **Paiement**: espèces, carte, virement; lettrage facture.
- **Vacation (Shift)**: ouverture/fermeture, agent, fonds de caisse, totaux.
- **Catalogue codes postaux**: référentiel mondial (source externe ou licence).

### 4. Parcours utilisateurs clés
4.1. **Création d’un envoi (agent)**
1) Identifier le client (passager ou abonné)
2) Saisir expéditeur/destinataire, code postal, service choisi
3) Calculer le prix (tarif + options + surcharges + taxes)
4) Encaisser (ou mettre en compte si abonné)
5) Générer **étiquette** et **reçu** imprimables

4.2. **Facturation abonné (mensuelle)**
1) Consolider tous les envois du mois non facturés
2) Générer la **facture** en TND (TVA configurable)
3) Émettre facture PDF + envoi email
4) Suivi des paiements et relances

4.3. **Vacation de guichet**
1) Ouvrir la vacation (fonds de caisse initial)
2) Enregistrer toutes les opérations (ventes, remboursements)
3) Clôturer: produire **arrêt de situation** (totaux par mode de paiement, nombre d’envois, écarts)

### 5. Intégrations et référentiels
- **Codes postaux mondiaux**: API (ex: Zippopotam, Geonames) ou base licenciée.
- **Change & taxes**: TVA TND paramétrable, taux de change (si affichage informatif multi-devises).
- **Paiements**: passerelles carte/virement (optionnel), impression thermique.

### 6. Exigences fonctionnelles
- Gestion CRUD: clients, adresses, bureaux, tarifs, envois, factures, paiements.
- Génération de documents: étiquette, reçu, facture (PDF/HTML imprimable).
- Suivi d’envoi: statut, événements de tracking.
- Facturation mensuelle: sélection période, numérotation, PDF, export comptable.
- Reporting: par agent, par bureau, par période; exports CSV/Excel.

### 7. Exigences non-fonctionnelles
- **Sécurité**: RBAC, JWT/OAuth2, journalisation, traçabilité.
- **Disponibilité**: sauvegardes, reprise, monitoring.
- **Performance**: réponses < 300 ms pour opérations guichet.
- **I18n**: FR/EN (extensible), formats régionaux.

### 8. Conformité et audit
- Numérotation légale des factures, mentions obligatoires, conservation.
- Piste d’audit (qui fait quoi, quand), immutabilité des factures émises.

### 9. Roadmap d’implémentation (résumé)
1) Modèle de données (PostgreSQL)
2) API (OpenAPI 3.0), auth
3) UI guichet + Espace client abonné
4) Génération documents (HTML→PDF)
5) Facturation mensuelle et reporting

