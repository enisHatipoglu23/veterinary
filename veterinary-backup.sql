PGDMP                      |         
   veterinary    16.2    16.2 7    G           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            H           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            I           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            J           1262    25280 
   veterinary    DATABASE     l   CREATE DATABASE veterinary WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE veterinary;
                postgres    false            �            1259    25290    animal2vaccines    TABLE     �   CREATE TABLE public.animal2vaccines (
    animal2vaccines_animal_id bigint NOT NULL,
    animal2vaccines_vaccine_id bigint NOT NULL
);
 #   DROP TABLE public.animal2vaccines;
       public         heap    postgres    false            �            1259    25282    animals    TABLE     )  CREATE TABLE public.animals (
    animal_id bigint NOT NULL,
    breed character varying(255),
    color character varying(255),
    date_of_birth date,
    gender character varying(255),
    animal_name character varying(255),
    species character varying(255),
    animal_customer_id bigint
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    25281    animals_animal_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.animals_animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.animals_animal_id_seq;
       public          postgres    false    216            K           0    0    animals_animal_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.animals_animal_id_seq OWNED BY public.animals.animal_id;
          public          postgres    false    215            �            1259    25294    appointments    TABLE     �   CREATE TABLE public.appointments (
    appointment_id bigint NOT NULL,
    appointment_date date,
    appointment_animal_id bigint,
    appointment_doctor_id bigint,
    appointment_time time(6) without time zone
);
     DROP TABLE public.appointments;
       public         heap    postgres    false            �            1259    25293    appointments_appointment_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_appointment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.appointments_appointment_id_seq;
       public          postgres    false    219            L           0    0    appointments_appointment_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.appointments_appointment_id_seq OWNED BY public.appointments.appointment_id;
          public          postgres    false    218            �            1259    25301    available_dates    TABLE     �   CREATE TABLE public.available_dates (
    available_date_id bigint NOT NULL,
    available_date date,
    available_date_doctor_id bigint
);
 #   DROP TABLE public.available_dates;
       public         heap    postgres    false            �            1259    25300 %   available_dates_available_date_id_seq    SEQUENCE     �   CREATE SEQUENCE public.available_dates_available_date_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE public.available_dates_available_date_id_seq;
       public          postgres    false    221            M           0    0 %   available_dates_available_date_id_seq    SEQUENCE OWNED BY     o   ALTER SEQUENCE public.available_dates_available_date_id_seq OWNED BY public.available_dates.available_date_id;
          public          postgres    false    220            �            1259    25308 	   customers    TABLE        CREATE TABLE public.customers (
    customer_id bigint NOT NULL,
    customer_address character varying(255),
    customer_city character varying(255),
    customer_mail character varying(255),
    customer_name character varying(255),
    customer_phone_number character varying(255)
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    25307    customers_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.customers_customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.customers_customer_id_seq;
       public          postgres    false    223            N           0    0    customers_customer_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.customers_customer_id_seq OWNED BY public.customers.customer_id;
          public          postgres    false    222            �            1259    25317    doctors    TABLE       CREATE TABLE public.doctors (
    doctor_id bigint NOT NULL,
    doctor_address character varying(255),
    doctor_city character varying(255),
    doctor_mail character varying(255),
    doctor_name character varying(255),
    doctor_phone_number character varying(255)
);
    DROP TABLE public.doctors;
       public         heap    postgres    false            �            1259    25316    doctors_doctor_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.doctors_doctor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.doctors_doctor_id_seq;
       public          postgres    false    225            O           0    0    doctors_doctor_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.doctors_doctor_id_seq OWNED BY public.doctors.doctor_id;
          public          postgres    false    224            �            1259    25326    vaccines    TABLE     �   CREATE TABLE public.vaccines (
    vaccine_id bigint NOT NULL,
    code character varying(255),
    vaccine_name character varying(255),
    protection_end_date date,
    protection_start_date date,
    animal_id bigint
);
    DROP TABLE public.vaccines;
       public         heap    postgres    false            �            1259    25325    vaccines_vaccine_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vaccines_vaccine_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.vaccines_vaccine_id_seq;
       public          postgres    false    227            P           0    0    vaccines_vaccine_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.vaccines_vaccine_id_seq OWNED BY public.vaccines.vaccine_id;
          public          postgres    false    226            �           2604    25285    animals animal_id    DEFAULT     v   ALTER TABLE ONLY public.animals ALTER COLUMN animal_id SET DEFAULT nextval('public.animals_animal_id_seq'::regclass);
 @   ALTER TABLE public.animals ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    215    216    216            �           2604    25297    appointments appointment_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN appointment_id SET DEFAULT nextval('public.appointments_appointment_id_seq'::regclass);
 J   ALTER TABLE public.appointments ALTER COLUMN appointment_id DROP DEFAULT;
       public          postgres    false    219    218    219            �           2604    25304 !   available_dates available_date_id    DEFAULT     �   ALTER TABLE ONLY public.available_dates ALTER COLUMN available_date_id SET DEFAULT nextval('public.available_dates_available_date_id_seq'::regclass);
 P   ALTER TABLE public.available_dates ALTER COLUMN available_date_id DROP DEFAULT;
       public          postgres    false    220    221    221            �           2604    25311    customers customer_id    DEFAULT     ~   ALTER TABLE ONLY public.customers ALTER COLUMN customer_id SET DEFAULT nextval('public.customers_customer_id_seq'::regclass);
 D   ALTER TABLE public.customers ALTER COLUMN customer_id DROP DEFAULT;
       public          postgres    false    222    223    223            �           2604    25320    doctors doctor_id    DEFAULT     v   ALTER TABLE ONLY public.doctors ALTER COLUMN doctor_id SET DEFAULT nextval('public.doctors_doctor_id_seq'::regclass);
 @   ALTER TABLE public.doctors ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    224    225    225            �           2604    25329    vaccines vaccine_id    DEFAULT     z   ALTER TABLE ONLY public.vaccines ALTER COLUMN vaccine_id SET DEFAULT nextval('public.vaccines_vaccine_id_seq'::regclass);
 B   ALTER TABLE public.vaccines ALTER COLUMN vaccine_id DROP DEFAULT;
       public          postgres    false    227    226    227            :          0    25290    animal2vaccines 
   TABLE DATA           `   COPY public.animal2vaccines (animal2vaccines_animal_id, animal2vaccines_vaccine_id) FROM stdin;
    public          postgres    false    217   cD       9          0    25282    animals 
   TABLE DATA           {   COPY public.animals (animal_id, breed, color, date_of_birth, gender, animal_name, species, animal_customer_id) FROM stdin;
    public          postgres    false    216   �D       <          0    25294    appointments 
   TABLE DATA           �   COPY public.appointments (appointment_id, appointment_date, appointment_animal_id, appointment_doctor_id, appointment_time) FROM stdin;
    public          postgres    false    219   E       >          0    25301    available_dates 
   TABLE DATA           f   COPY public.available_dates (available_date_id, available_date, available_date_doctor_id) FROM stdin;
    public          postgres    false    221   BE       @          0    25308 	   customers 
   TABLE DATA           �   COPY public.customers (customer_id, customer_address, customer_city, customer_mail, customer_name, customer_phone_number) FROM stdin;
    public          postgres    false    223   uE       B          0    25317    doctors 
   TABLE DATA           x   COPY public.doctors (doctor_id, doctor_address, doctor_city, doctor_mail, doctor_name, doctor_phone_number) FROM stdin;
    public          postgres    false    225   F       D          0    25326    vaccines 
   TABLE DATA           y   COPY public.vaccines (vaccine_id, code, vaccine_name, protection_end_date, protection_start_date, animal_id) FROM stdin;
    public          postgres    false    227   zF       Q           0    0    animals_animal_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.animals_animal_id_seq', 8, true);
          public          postgres    false    215            R           0    0    appointments_appointment_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.appointments_appointment_id_seq', 4, true);
          public          postgres    false    218            S           0    0 %   available_dates_available_date_id_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public.available_dates_available_date_id_seq', 2, true);
          public          postgres    false    220            T           0    0    customers_customer_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.customers_customer_id_seq', 8, true);
          public          postgres    false    222            U           0    0    doctors_doctor_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.doctors_doctor_id_seq', 2, true);
          public          postgres    false    224            V           0    0    vaccines_vaccine_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.vaccines_vaccine_id_seq', 8, true);
          public          postgres    false    226            �           2606    25289    animals animals_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (animal_id);
 >   ALTER TABLE ONLY public.animals DROP CONSTRAINT animals_pkey;
       public            postgres    false    216            �           2606    25299    appointments appointments_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT appointments_pkey PRIMARY KEY (appointment_id);
 H   ALTER TABLE ONLY public.appointments DROP CONSTRAINT appointments_pkey;
       public            postgres    false    219            �           2606    25306 $   available_dates available_dates_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT available_dates_pkey PRIMARY KEY (available_date_id);
 N   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT available_dates_pkey;
       public            postgres    false    221            �           2606    25315    customers customers_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (customer_id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    223            �           2606    25324    doctors doctors_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (doctor_id);
 >   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_pkey;
       public            postgres    false    225            �           2606    25333    vaccines vaccines_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT vaccines_pkey PRIMARY KEY (vaccine_id);
 @   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT vaccines_pkey;
       public            postgres    false    227            �           2606    25339 +   animal2vaccines fk1km02036a97xii8irpddkpcc7    FK CONSTRAINT     �   ALTER TABLE ONLY public.animal2vaccines
    ADD CONSTRAINT fk1km02036a97xii8irpddkpcc7 FOREIGN KEY (animal2vaccines_animal_id) REFERENCES public.animals(animal_id);
 U   ALTER TABLE ONLY public.animal2vaccines DROP CONSTRAINT fk1km02036a97xii8irpddkpcc7;
       public          postgres    false    3479    217    216            �           2606    25354 '   appointments fk27d0xcbajwaeeun2doojsae4    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk27d0xcbajwaeeun2doojsae4 FOREIGN KEY (appointment_doctor_id) REFERENCES public.doctors(doctor_id);
 Q   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fk27d0xcbajwaeeun2doojsae4;
       public          postgres    false    225    3487    219            �           2606    25364 $   vaccines fkeasdy15b2kp5j4k13x2dfudqs    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs FOREIGN KEY (animal_id) REFERENCES public.animals(animal_id);
 N   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs;
       public          postgres    false    227    216    3479            �           2606    25359 *   available_dates fkf7jtwolyhaj07c4oh0j4pncb    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT fkf7jtwolyhaj07c4oh0j4pncb FOREIGN KEY (available_date_doctor_id) REFERENCES public.doctors(doctor_id);
 T   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT fkf7jtwolyhaj07c4oh0j4pncb;
       public          postgres    false    3487    225    221            �           2606    25334 +   animal2vaccines fklycbmwlximp2qug7jl6yown04    FK CONSTRAINT     �   ALTER TABLE ONLY public.animal2vaccines
    ADD CONSTRAINT fklycbmwlximp2qug7jl6yown04 FOREIGN KEY (animal2vaccines_vaccine_id) REFERENCES public.vaccines(vaccine_id);
 U   ALTER TABLE ONLY public.animal2vaccines DROP CONSTRAINT fklycbmwlximp2qug7jl6yown04;
       public          postgres    false    217    227    3489            �           2606    25344 #   animals fknjsvd8kplxqmf48ybxayrx6ru    FK CONSTRAINT     �   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fknjsvd8kplxqmf48ybxayrx6ru FOREIGN KEY (animal_customer_id) REFERENCES public.customers(customer_id);
 M   ALTER TABLE ONLY public.animals DROP CONSTRAINT fknjsvd8kplxqmf48ybxayrx6ru;
       public          postgres    false    216    223    3485            �           2606    25349 (   appointments fko4t945rb708af9ry6syof7bwt    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fko4t945rb708af9ry6syof7bwt FOREIGN KEY (appointment_animal_id) REFERENCES public.animals(animal_id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fko4t945rb708af9ry6syof7bwt;
       public          postgres    false    3479    219    216            :      x������ � �      9   �   x�3����t/J��4200�5��50��M�I���/JI���.-*Q�>�� ���LNc.s����̒T�#]�&#�����I �y�9@�� �N9��� �@�Mt-!J�R+K2�8����r��qqq �&+�      <   "   x�3�4202�50�50�Cc+ ����� R;�      >   #   x�3�4202�50"NC.C(�T��ȍ���� h"�      @   �   x�E�M� ���p������#5nL��RH�(���s{��8�w�|�AJ���!5�0���s���PJ��$�B�Ч)��m��}ٜ��x�}I�VuZm��L�ּ���r�`Gk�}�d�BP�WiW��Y��έ�~ȉ��8mc =4>      B   U   x�3�46501�t�+I̩L��O/�r �� ����������ˈ���Ȇ�ļ���Č��0��&��M�!b���� d�4      D      x������ � �     