(function ($) {
    let request = $.ajax({'url': '/posts.json'});
    request.done(function (posts) {
        let html = '';
        posts.forEach(function (post) {
            html += `<div class="media-object">
                        <div class= "media-object-section">
                            <a href="../posts/${post.id}">
                                <h4>${post.title}</h4>
                            </a>
                            <p>Published by ${post.owner.username}</p>
                            <p> ${post.body}</p>
                        </div>
                    </div>`;
        });
        $('#posts').html(html);
    });
})(jQuery);