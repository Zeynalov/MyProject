<#import "macro/common.ftl" as c>

<@c.page>
Order

<div>
    <form action="/order" method="post">
        <#list messages?ifExists as message>
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Order</th>
                   <#-- <th>
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Example textarea</label>
                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                        </div>
                    </th>-->
                    <th scope="col">OrderStatus</th>
                    <th scope="col">Author</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">${message.id}</th>
                    <td>${message.application}</td>
                    <td><#list message.orderStatus as order>${order}</#list></td>
                    <td>${message.authorName}</td>
                </tr>
                </tbody>
            </table>
        </#list>
    </form>
</div>

</@c.page>