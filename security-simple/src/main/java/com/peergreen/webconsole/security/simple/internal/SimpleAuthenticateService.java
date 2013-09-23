/**
 * Peergreen S.A.S. All rights reserved.
 * Proprietary and confidential.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.peergreen.webconsole.security.simple.internal;

import javax.security.auth.Subject;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;

import com.peergreen.webconsole.security.AuthenticateService;
import com.peergreen.webconsole.security.RoleGroup;
import com.peergreen.webconsole.security.UserPrincipal;

/**
 * @author Mohammed Boukada
 */
@Component
@Instantiate
@Provides
public class SimpleAuthenticateService implements AuthenticateService {

    @Override
    public Subject authenticate(String username, String password) {
        Subject defaultSubject = new Subject();
        defaultSubject.getPrincipals().add(new UserPrincipal(username));
        defaultSubject.getPrincipals().add(new RoleGroup());
        defaultSubject.setReadOnly();
        return defaultSubject;
    }
}
