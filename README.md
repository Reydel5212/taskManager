    <form th:method="POST" th:action="@{/editInfo/{id} (id = ${desc.getId()})}">
        <textarea th:field="*{desc.first_para}"></textarea>
        <textarea th:field="*{desc.second_para}"></textarea>

        <input type="submit" value="Отправить">
    </form>