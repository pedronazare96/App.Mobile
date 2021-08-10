# App.Mobile
Meu primeiro Projeto utilizando o Android Studio 
Iniciei o projeto utilizando uma herenaça extendendo a classe Activity em seguida declarei a Activity no manifesto do Android para poder executar o projeto controlando uma tag aplicando a action como MAIN e category como LAUNCHER. Modifique o estado de criação (onCreate ()) da Activity para que apareça um Toast Implemente o primeiro layout da Activity, para isso, crie o layout de seleção na pasta res, em seguida, crie o arquivo de layout com o nome activity_main, nesse arquivo considere o LinearLayout como elemento raiz. Referindo um TextView com o texto indicando o nome de um cliente. Comece implementando como views que vão representar os alunos adicionando 3 TextViews. Em seguida, sem código Java, busque as views por meio do método findViewById () enviando os ids via argumento. 

Configure o adaptador a partir da classe ArrayAdapter enviando o contexto, layout do Android Framework (android.R.layout.simple_list_item_1) e a lista de cliente via argumento Implemente o FloatingActionButton como botão para adicionar novos clientes 

Clique no botão que representa o download da dependência. Assim que finalizar o processo do Gradle, dependerá do FAB (FloatingActionButton) sem layout. Em seguida converta o LinearLayout para RelativeLayout utilizando o menu Converter Visualizar ... clicando com o botão direito em cima do LinearLayout a partir da aba Component Tree. 

Por fim, mova o FAB para uma tela de visualização, se é apresentado na tela do preview e se o posicionamento no Component Tree correto: Para Padronizar o botão de adcionar pessoas utilizei uma margem de "26dp" Nesse proximo está posicionado o icone dentro do botão de adcionar, fiz isso utilizando "imagens" drawable e selecione o icone desejado assim como a cor. e alterar a extensão de Activity para uma AppCompatActivity para adcionar o nome "Lista de clientes" utiliza o procedimento do Android Studio entrando no pacote raiz (local onde está uma MainActivity) e usando uma opção Novo (Alt + Insert). Filtre pela opção "activity" então navegue até a opção Gallery. Em seguida, preencha os campos solicitados, defina o nome da Activity como FormularioClienteActivity, marque a opção Launcher Activity e deixe as opções Gerar arquivo de layout e compatibilidade com versões anteriores (AppCompat) marcadas. Defina um pacote específico para uma atividade, vimos que podemos deixar dentro de atividade ou ui.atividade, escolha uma maneira que preferir, porém, dependente-se que vai ficar em um pacote reservado para Atividades. Então clique em Concluir Altere o arquivo de manifesto para que somente uma Activity de formulário seja executada durante o lançamento PRÓXIMO VEZ VAMOS ADCIONAR NOSSOS NOVO CLIENTE preencher os campos do formulário e tocar no botão Salvar. 

Para isso, apl ique um listener no botão Salvar a partir do método setOnClickListener () e implemente uma interface View.OnClickListener () utilizando uma técnica de classe anônima. 

Dentro do método onClick () do listener, implemente o código para pegar o conteúdo de cada um dos EditTexts e atribuir variáveis do tipo String. Dentro do escopo do onClick (), com as variáveis de nome, telefone, data, modelo e orçamento, crie uma classe modelo para representar um cliente que receba ambas as variáveis via construtor e atributos para atributos de classe. 

Por fim, após criar um objeto do tipo Cliente, manter um Toast para que apresente as informações do aluno quando uma ação de clique ocorrer de acordo com os dados dos EditTexts. Rode o App e faça o teste, veja se apresenta as informações como esperado. Farei com que o cliente criado pelo formulário seja apresentado na lista de cliente da ListaClienteActivity. 

Para isso, criei um Dao que vai ficar responsável em armazenar cliente que serão criados pelo formulário. 

Dentro do Dao implementei o método salva () que recebe um cliente. Com o método declarado, implementa uma solução de persistência por meio da memória, criando um atributo privado estático do tipo List. 

Em seguida, fiz uma inicialização do mesmo e, dentro do salva (), chamei o método add () da lista enviando o cliente recebido via parâmetro. 

Com o método salva () disponível, criei uma instância do ClienteDao antes do ouvinte, então, no momento que criar o cliente, chame o método salva () do Dao enviando o cliente criado. 

Na ListaClienteActivity, criei uma instância de ClienteDao, então, criei o método todos () que devolva uma cópia da lista estática de referência. Modifiquei o terceiro argumento do construtor do ArrayAdapter para que receba o método todos () do Dao. Por fim, pressiona e modifiquei o toString () da classe Cliente para que retorne o nome do atributo. 

Para testar o comportamento novo, após salvar o cliente, chame o método startActivity enviando o contexto do FormularioClienteActivity e a referência de classe da ListaClienteActivity respectivamente via argumento. Execute o App e veja se o formulário salva o cliente a apresenta o cliente na lista de clientes. 

Ajuste o fluxo do App para que ele entre na primeira lista de cliente, então, ao tocar fab entre no formulário e realizar o procedimento de salvar o cliente da maneira esperada. 

Para isso, ajuste o arquivo de manifesto do Android para que a lista de alunos seja um launcher. Então, incorporar um listener no fab para que inicie um FormularioClienteActivity Em seguida, migrei o código que configura o adaptador no ListView e deixei no onResume () para evitar o problema de não apresentar os clientes salvos. 

Em seguida, na FormularioClienteActivity, ao deixar de inicializar a ListaClienteActivity ao salvar o cliente, finalizar uma Activity a partir do método finish ().

Implemente o listener para cada item do ListView, utilizando para isso o método setOnItemClickListener() que recebe a interface AdapterView.OnItemClickListener como argumento. Faça essa implementação por meio de uma classe anônima.
Primeiro busque o cliente na lista devolvida pelo DAO dentro do onItemClick(). Para isso, utilize o parâmetro de posição.

Para enviar o aluno, utilize o extra da Intent por meio do método putExtra(). Lembre-se que é necessário enviar a chave como uma String e o cliente como valor.

A técnica de transferência via extra, exige que o dado seja serializável. Sendo assim, faça com o que a classe Cliente implemente a interface Serializable.

Na Activity de formulário, dentro do o onCreate() pegue a Intent com o método getIntent(), em seguida, recupere o aluno que foi enviado por meio do método getSerializableExtra() enviando a mesma chave utilizada no putExtra(). Lembre-se que é retornada a interface Serializable, ou seja, vai ser necessário fazer o casting para Cliente.
Sendo assim, modifique a classe Cliente para que tenha um id, utilize o tipo int para o id. Altere o DAO para que gere um id novo para cada cliente que for salvo.
Crie o método edita() que recebe um cliente. Nesta implementação, primeiro implemente o código que busca um cliente a partir do seu id. Essa busca pode ou não encontrar um cliente, portanto, antes de editar certifique-se que o cliente não é uma referência nula.

Para a edição, busque a posição do cliente que foi encontrado, então utilize o método set() da lista de cliente, enviando a posição do cliente encontrado e o cliente que foi enviado via parâmetro respectivamente.Em seguida, renomeie o método criaAluno() para preencheCliente(), e então, ao invés de criar um cliente, altere as informações do atributo que representa o cliente. Consequentemente esse método não vai mais devolver um Cliente, portanto, mude a assinatura para void
Dentro do listener do botão salvar. Comente o código que salva, então, adicione o código que edita o cliente. Para a edição, primeiro chame o método preencheCliente() e depois o edita() do DAO, enviando o atributo cliente.

Por fim, chame o método finish() para que o formulário seja fechado e a lista atualizada.
Agora para finalizar o projeto refatorei o código. 
