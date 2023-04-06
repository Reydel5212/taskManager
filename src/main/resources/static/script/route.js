
const app = document.querySelector(".homeSectionContentBar")
const pageText = document.querySelector(".flexer")

const locationResolver = (location) => {
    switch (location) {

        case "#/main":
            pageText.innerHTML=`
            <p class="text">Главная</p> 
            `
            app.innerHTML = `
            <!--table-->
            <div class="tableContentBar">
              <div class="homeSectionContentBarTable">
                  
                    <div class="tableContentCell">
                      <p class="tableCell tableHeaderText">Текущие задачи</p>
                    </div>
      
                    <div class="tableContentCell">
                        <p class="tableCell tableHeaderText">Название</p>
                        <p class="tableCell tableHeaderText">Срок Сдачи</p>
                        <p class="tableCell tableHeaderText">Действие</p>
                    </div>
                    
                    <div class="tableContentCell tableContentHover">
                      <p class="tableCell tableTaskText">Плановая проверка системы</p>
                      <p class="tableCell tableTaskText">20.12.23 - 20:30PM</p>
                      <!--<p class="tableCell tableTaskText button">Отменить</p>-->
                      <div class="tableCell flexPositon">
                          <input type="button" class="tableTaskText button" value="Отменить">
                      </div>
                    </div>
                    <!--<p class="tableCell hiddenText">Задачи отсутствуют</p>--> <!--Hidden if no tasks-->
                    
            </div>
            `
        break;
        case "#/mytask":
            pageText.innerHTML=`
            <p class="text">Мои задачи</p>     <!--change-->
            `
            app.innerHTML = `
            <!--table-->
            <div class="tableContentBar">
              <div class="homeSectionContentBarTable">
                  
                    <div class="tableContentCell">
                      <p class="tableCell tableHeaderText">Текущие задачи</p>
                    </div>
      
                    <div class="tableContentCell">
                        <p class="tableCell tableHeaderText">Название</p>
                        <p class="tableCell tableHeaderText">Исполнитель</p>
                        <p class="tableCell tableHeaderText">Срок Сдачи</p>
                        <p class="tableCell tableHeaderText">Действие</p>
                    </div>
                    
                    <div class="tableContentCell tableContentHover">
                      <p class="tableCell tableTaskText">Плановая проверка системы</p>
                      <p class="tableCell tableTaskText">Райан Гослинг</p>
                      <p class="tableCell tableTaskText">20.12.23 - 20:30PM</p>
                      <!--<p class="tableCell tableTaskText button">Отменить</p>-->
                      <div class="tableCell flexPositon">
                          <input type="button" class="tableTaskText button" value="Отменить">
                      </div>
                    </div>
                    <!--<p class="tableCell hiddenText">Задачи отсутствуют</p>--> <!--Hidden if no tasks-->
                    
            </div>
            `
        break;
        case "#/stat":
            pageText.innerHTML=`
            <p class="text">Статистика</p>     <!--change-->
            `
            app.innerHTML = `
            <!--table-->
            <div class="tableContentBar">
              <div class="homeSectionContentBarTable">
                  
                    <div class="tableContentCell">
                      <p class="tableCell tableHeaderText">Всего выполненно</p>

                    </div>
                    <div class="tableContentCell">
                        <p class="tableCell tableHeaderText">0</p>
                    </div>
      
                    <div class="tableContentCell">
                        <p class="tableCell tableHeaderText">Название</p>
                        <p class="tableCell tableHeaderText">Дата выполнения</p>
                        <p class="tableCell tableHeaderText">Время выполнения</p>
                    </div>
                    
                    <div class="tableContentCell tableContentHover">
                      <p class="tableCell tableTaskText">Плановая проверка системы</p>
                      <p class="tableCell tableTaskText">20.12.23</p>
                      <p class="tableCell tableTaskText">20:30PM</p>
                    </div>
                    <!--<p class="tableCell hiddenText">Задачи отсутствуют</p>--> <!--Hidden if no tasks-->
            </div>
            `
        break;
        case "#/settings":
            pageText.innerHTML=`
            <p class="text">Настройки</p>     <!--change-->
            `
            app.innerHTML = `
            <!--table-->
            <div class="tableContentBar">
                <div class="contentCenterBar">
                    <div class="changeColorContainer changeColorDark">
                        <div class="changeColorContainerIn changeColorContainerInDark">
                            <p>Settings</p>
                        </div>
                    </div>
                    <div class="changeColorContainer changeColorLight">
                        <div class="changeColorContainerIn changeColorContainerInLight">
                            <p>Settings</p>
                        </div>
                    </div>
                    <div class="changeColorContainer changeColorGrey">
                        <div class="changeColorContainerIn changeColorContainerInGrey">
                            <p>Settings</p>
                        </div>
                    </div>
                </div>
            </div>
            `
        break;
        case "#/info":
            pageText.innerHTML=`
            <p class="text">Информация</p>     <!--change-->
            `
            app.innerHTML = `
            <!--table-->
            <div class="tableContentBar">
                <div class="contentCenterBar">
                    <div class="containerCenterInfo">
                        <h2>Информация о проекте</h2>
                
                        <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed posuere non est at tincidunt. In pretium interdum facilisis. 
                        Mauris eu mauris a dolor varius porta. Donec faucibus neque sed est posuere, nec sagittis nisi commodo. 
                        Fusce ornare augue pretium, laoreet odio in, efficitur ex. Proin a nibh vitae justo ultricies aliquet. 
                        Maecenas vel ligula dignissim, hendrerit sapien et, hendrerit odio. Proin imperdiet a nisl vel feugiat. 
                        Cras euismod mattis nunc, sit amet consectetur nunc cursus vitae. Maecenas diam nibh, cursus id sapien quis, mattis molestie nunc. Donec rutrum lacinia lectus sed porta.
                        Donec ullamcorper lobortis diam ac egestas. Maecenas vitae pretium enim, a laoreet magna. Vestibulum venenatis lorem quis porttitor congue.
                        Maecenas lobortis maximus odio rutrum tempor. Curabitur ornare quis odio nec dignissim.</p>
                        <p>
                        <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed posuere non est at tincidunt. In pretium interdum facilisis. 
                        Mauris eu mauris a dolor varius porta. Donec faucibus neque sed est posuere, nec sagittis nisi commodo. 
                        Fusce ornare augue pretium, laoreet odio in, efficitur ex. Proin a nibh vitae justo ultricies aliquet. 
                        Maecenas vel ligula dignissim, hendrerit sapien et, hendrerit odio. Proin imperdiet a nisl vel feugiat. 
                        Cras euismod mattis nunc, sit amet consectetur nunc cursus vitae. Maecenas diam nibh, cursus id sapien quis, mattis molestie nunc. Donec rutrum lacinia lectus sed porta.
                        Donec ullamcorper lobortis diam ac egestas. Maecenas vitae pretium enim, a laoreet magna. Vestibulum venenatis lorem quis porttitor congue.
                        Maecenas lobortis maximus odio rutrum tempor. Curabitur ornare quis odio nec dignissim.</p>
                    </div>
                </div>
            </div>
            `
        break;

    }
}

window.addEventListener('load', () => {
    const location = window.location.hash

    if (location) {
        locationResolver(location)
    }
})

